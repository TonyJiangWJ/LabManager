package com.labcode.controller;

import com.labcode.entity.StudentInfo;
import com.labcode.entity.TeacherInfo;
import com.labcode.entity.TeamInfo;
import com.labcode.entity.TeamStudentRef;
import com.labcode.request.*;
import com.labcode.response.*;
import com.labcode.service.StudentInfoService;
import com.labcode.service.TeacherInfoService;
import com.labcode.service.TeamInfoService;
import com.labcode.service.TeamStudentRefService;
import com.labcode.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Author jiangwj20966 on 2017/6/7.
 */
@RestController
@RequestMapping("/labcode")
public class MergedController {

    @Resource
    private StudentInfoService studentInfoService;
    @Resource
    private TeacherInfoService teacherInfoService;
    @Resource
    private TeamInfoService teamInfoService;
    @Resource
    private TeamStudentRefService teamStudentRefService;

    private Logger logger = LoggerFactory.getLogger(MergedController.class);

    @RequestMapping("/user/login")
    public LoginResponse doLogin(@ModelAttribute("request") LoginRequest request) {
        LoginResponse response = new LoginResponse();

        if (StringUtils.isEmpty(request.getPassword())
                || StringUtils.isEmpty(request.getUserName())
                || StringUtils.isEmpty(request.getLoginType())) {
            return (LoginResponse) ResponseUtil.paramError(response);
        }
        if (request.getLoginType().equals("student")) {
            StudentInfo studentInfo = new StudentInfo();
            studentInfo.setStudentName(request.getUserName());
            studentInfo.setPwd(request.getPassword());
            List<StudentInfo> studentInfos = studentInfoService.find(studentInfo);
            if (CollectionUtils.isEmpty(studentInfos)) {
                return (LoginResponse) ResponseUtil.error(response);
            } else {
                studentInfo = studentInfos.get(0);
                response.setUserName(studentInfo.getStudentName());
                response.setUserType("student");
                response.setUserId(studentInfo.getStudentId());
            }
        } else if (request.getLoginType().equals("teacher")) {
            TeacherInfo teacherInfo = new TeacherInfo();
            teacherInfo.setTeacherName(request.getUserName());
            teacherInfo.setPwd(request.getPassword());
            List<TeacherInfo> teacherInfos = teacherInfoService.find(teacherInfo);
            if (CollectionUtils.isEmpty(teacherInfos)) {
                return (LoginResponse) ResponseUtil.error(response);
            } else {
                teacherInfo = teacherInfos.get(0);
                response.setUserName(teacherInfo.getTeacherName());
                response.setUserType("teacher");
                response.setUserId(teacherInfo.getTeacherId());
            }
        } else {
            return (LoginResponse) ResponseUtil.paramError(response);
        }
        ResponseUtil.success(response);
        return response;
    }


    @RequestMapping("/student/info/get")
    public StudentInfoResponse getStudentInfo(@RequestParam("studentId") Integer studentId) {
        StudentInfoResponse response = new StudentInfoResponse();
        if (studentId == null) {
            return (StudentInfoResponse) ResponseUtil.paramError(response);
        }
        try {
            StudentInfo studentInfo = new StudentInfo();
            studentInfo.setStudentId(studentId);
            studentInfo = studentInfoService.findByID(studentId);
            if (studentInfo != null) {
                TeamStudentRef tsRef = new TeamStudentRef();
                tsRef.setStudentId(studentId);
                List<TeamStudentRef> teamStudentRefs = teamStudentRefService.find(tsRef);
                List<TeamInfo> teamInfos = new ArrayList<TeamInfo>();
                for (TeamStudentRef entity : teamStudentRefs) {
                    TeamInfo t = teamInfoService.findByID(entity.getTeamId());
                    if (t != null) {
                        teamInfos.add(t);
                    }
                }
                response.setEmail(studentInfo.getEmail());
                response.setGender(studentInfo.getGender());
                response.setStudentId(studentId);
                response.setStudentName(studentInfo.getStudentName());
                response.setStudentNo(studentInfo.getStudentNo());
                response.setTeamInfo(teamInfos);
                ResponseUtil.success(response);
                return response;
            } else {
                return (StudentInfoResponse) ResponseUtil.dataNotExisting(response);
            }
        } catch (Exception e) {
            ResponseUtil.sysError(response);
            logger.error("", e);
        }
        return response;
    }

    @RequestMapping("/update/teacher/info")
    public BaseResponse updateTeacherInfo(@ModelAttribute("request") UpdateTeacherInfoReq request) {
        try {
            TeacherInfo teacherInfo = teacherInfoService.findByID(request.getTeacherId());
            if (teacherInfo != null) {
                teacherInfo.setTeacherName(request.getTeacherName());
                teacherInfo.setGender(request.getGender());
                teacherInfo.setTeacherNo(request.getTeacherNo());

                if (teacherInfoService.update(teacherInfo) > 0) {
                    return ResponseUtil.success(null);
                } else {
                    return ResponseUtil.error(null);
                }
            } else {
                return ResponseUtil.dataNotExisting(null);
            }
        } catch (Exception e) {
            logger.error("", e);
            return ResponseUtil.sysError(null);
        }
    }

    @RequestMapping("/teacher/info/get")
    public TeacherInfoResponse getTeacherInfo(@RequestParam("teacherId") Integer teacherId) {
        TeacherInfoResponse response = new TeacherInfoResponse();
        if (teacherId == null) {
            return (TeacherInfoResponse) ResponseUtil.paramError(response);
        }
        try {
            TeacherInfo teacherInfo = teacherInfoService.findByID(teacherId);
            if (teacherInfo == null) {
                return (TeacherInfoResponse) ResponseUtil.dataNotExisting(response);
            }
            response.setGender(teacherInfo.getGender());
            response.setTeacherId(teacherId);
            response.setTeacherName(teacherInfo.getTeacherName());
            response.setTeacherNo(teacherInfo.getTeacherNo());
            TeamInfo teamInfo = new TeamInfo();
            teamInfo.setTeamTeacherId(teacherId);
            List<TeamInfo> teamInfos = teamInfoService.find(teamInfo);
            if (!CollectionUtils.isEmpty(teamInfos)) {
                List<Integer> teamIds = new ArrayList<Integer>();
                response.setTeamInfoList(teamInfos);
                for (TeamInfo entity : teamInfos) {
                    teamIds.add(entity.getTeamId());
                }
                response.setTeamIdList(teamIds);
            }
        } catch (Exception e) {
            logger.error("", e);
            ResponseUtil.sysError(response);
        }
        ResponseUtil.success(response);
        return response;
    }

    @RequestMapping("/put/student/info")
    public BaseResponse putStudent(@ModelAttribute("request") InsertStudentInfoReq request) {
        if (StringUtils.isEmpty(request.getEmail())
                || StringUtils.isEmpty(request.getGender())
                || StringUtils.isEmpty(request.getStudentName())
                || StringUtils.isEmpty(request.getStudentNo())
                || StringUtils.isEmpty(request.getTeamId())) {
            return ResponseUtil.paramError(null);
        }
        try {
            StudentInfo studentInfo = new StudentInfo();
            studentInfo.setStudentNo(request.getStudentNo());
            if (CollectionUtils.isEmpty(studentInfoService.find(studentInfo))) {
                studentInfo.setStudentName(request.getStudentName());
                studentInfo.setEmail(request.getEmail());
                studentInfo.setGender(request.getGender());
                studentInfoService.insert(studentInfo);
                Integer studentId = studentInfo.getStudentId();
                TeamStudentRef teamStudentRef = new TeamStudentRef();
                teamStudentRef.setStudentId(studentId);
                teamStudentRef.setTeamId(request.getTeamId());
                teamStudentRefService.insert(teamStudentRef);
            } else {
                return ResponseUtil.error(null);
            }
        } catch (Exception e) {
            logger.error("", e);
            return ResponseUtil.sysError(null);

        }
        return ResponseUtil.success(null);
    }

    @RequestMapping("/update/student/info")
    public BaseResponse updateStudentInfo(@ModelAttribute("request") UpdateStudentInfoReq request) {
        try {
            StudentInfo studentInfo = studentInfoService.findByID(request.getStudentId());
            if (request.getType().equals("student")) {
                studentInfo.setEmail(request.getEmail());
            } else if (request.getType().equals("teacher")) {
                studentInfo.setEmail(request.getEmail());
                studentInfo.setStudentNo(request.getStudentNo());
                studentInfo.setGender(request.getGender());
                studentInfo.setStudentName(request.getStudentName());
            }
            if (studentInfoService.update(studentInfo) > 0) {
                return ResponseUtil.success(null);
            } else {
                return ResponseUtil.error(null);
            }
        } catch (Exception e) {
            logger.error("", e);
            return ResponseUtil.sysError(null);
        }
    }

    @RequestMapping("/delete/student/info")
    public BaseResponse deleteStudent(@ModelAttribute("request") DelStudentFromTeamReq request) {
        try {
            if (StringUtils.isEmpty(request.getStudentId()) || StringUtils.isEmpty(request.getTeamId())) {
                return ResponseUtil.paramError(null);
            }
            TeamStudentRef teamStudentRef = new TeamStudentRef();
            teamStudentRef.setTeamId(request.getTeamId());
            teamStudentRef.setStudentId(request.getStudentId());
            List<TeamStudentRef> rs = teamStudentRefService.find(teamStudentRef);
            if (!CollectionUtils.isEmpty(rs)) {
                for (TeamStudentRef ref : rs) {
                    teamStudentRefService.deleteById(ref);
                }
            }
            if (!StringUtils.isEmpty(request.getType()) || request.getType().equals("deleteStudent")) {
                StudentInfo studentInfo = studentInfoService.findByID(request.getStudentId());
                if (studentInfo != null) {
                    studentInfoService.deleteById(studentInfo);
                }
            }
            return ResponseUtil.success(null);
        } catch (Exception e) {
            logger.error("", e);
            return ResponseUtil.sysError(null);
        }
    }

    @RequestMapping("/put/team/info")
    public BaseResponse insertTeamInfo(@ModelAttribute("request") InsertTeamInfoReq request) {
        if (StringUtils.isEmpty(request.getTeacherId()) || StringUtils.isEmpty(request.getTeamName())) {
            return ResponseUtil.paramError(null);
        }
        TeamInfo teamInfo = new TeamInfo();
        teamInfo.setTeamTeacherId(request.getTeacherId());
        teamInfo.setTeamName(request.getTeamName());
        if (teamInfoService.insert(teamInfo) > 0) {
            return ResponseUtil.success(null);
        } else {
            return ResponseUtil.error(null);
        }
    }

    @RequestMapping("/list/student")
    public StudentListResponse listStudent(@ModelAttribute("request") ListStudentReq request) {
        StudentListResponse response = new StudentListResponse();
        if (StringUtils.isEmpty(request.getTeamId()) && StringUtils.isEmpty(request.getStudentName())) {
            return (StudentListResponse) ResponseUtil.paramError(response);
        }
        try {
            if (!StringUtils.isEmpty(request.getTeamId()) && !StringUtils.isEmpty(request.getStudentName())) {
                TeamStudentRef teamStudentRef = new TeamStudentRef();
                teamStudentRef.setTeamId(request.getTeamId());
                List<TeamStudentRef> refs = teamStudentRefService.find(teamStudentRef);
                List<StudentInfo> studentInfos = new ArrayList<StudentInfo>();
                if (!CollectionUtils.isEmpty(refs)) {
                    for (TeamStudentRef teamStudentRef1 : refs) {
                        studentInfos.add(studentInfoService.findByID(teamStudentRef1.getStudentId()));
                    }
                }
                StudentInfo studentInfo = new StudentInfo();
                studentInfo.setStudentName(request.getStudentName());
                List<StudentInfo> studentInfos1 = studentInfoService.fuzzyFind(studentInfo);
                List<StudentInfo> result = new ArrayList<StudentInfo>();
                for (StudentInfo entity : studentInfos) {
                    if (studentInfos1.contains(entity)) {
                        result.add(entity);
                    }
                }
                response.setStudentInfos(result);
            } else if (!StringUtils.isEmpty(request.getTeamId())) {
                TeamStudentRef teamStudentRef = new TeamStudentRef();
                teamStudentRef.setTeamId(request.getTeamId());
                List<TeamStudentRef> refs = teamStudentRefService.find(teamStudentRef);
                List<StudentInfo> studentInfos = new ArrayList<StudentInfo>();
                if (!CollectionUtils.isEmpty(refs)) {
                    for (TeamStudentRef teamStudentRef1 : refs) {
                        StudentInfo studentInfo = studentInfoService.findByID(teamStudentRef1.getStudentId());
                        if (studentInfo != null) {
                            studentInfos.add(studentInfoService.findByID(teamStudentRef1.getStudentId()));
                        }
                    }
                }
                response.setStudentInfos(studentInfos);
            } else {
                StudentInfo studentInfo = new StudentInfo();
                studentInfo.setStudentName(request.getStudentName());
                List<StudentInfo> studentInfos1 = studentInfoService.fuzzyFind(studentInfo);
                response.setStudentInfos(studentInfos1);
            }

        } catch (Exception e) {
            logger.error("", e);
            return (StudentListResponse) ResponseUtil.sysError(response);
        }
        if (CollectionUtils.isEmpty(response.getStudentInfos())) {
            return (StudentListResponse) ResponseUtil.dataNotExisting(response);
        }
        return (StudentListResponse) ResponseUtil.success(response);
    }
}
