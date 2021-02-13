package com.example.memento.demo;

public class ExamPaper {
    private String examinationPaperId;//试卷主键
    private String leavTime;//剩余时间
    private String organizationId;//单位主键
    private String id;//考试主键
    private String examRoomId;//考场主键
    private String userId;//用户主键
    private String specialtyCode;//专业代码
    private String postionCode;//报考岗位
    private String gradeCode;//报考等级
    private String examStartTime;//考试开始时间
    private String examEndTime;//考试结束时间
    private String singleSelectionImpCount;//单选选题重要数量
    private String multiSelectionImpCount;//多选题重要数量
    private String judgementImpCount;//判断题重要数量
    private String examTime;//考试时长
    private String fullScore;//总分
    private String passScore;//及格分
    private String userName;//学员姓名
    private String score;//考试得分
    private String resut;//是否及格
    private String singleOkCount;//单选题答对数量
    private String multiOkCount;//多选题答对数量
    private String judgementOkCount;//判断题答对数量

    public ExamPaper copy() {
        ExamPaper examPaper = new ExamPaper();
        //剩余时间
        examPaper.setLeavTime(this.getLeavTime());
        //单位主键
        examPaper.setOrganizationId(this.getOrganizationId());
        //考试主键
        examPaper.setId(this.getId());
        //用户主键
        examPaper.setUserId(this.getUserId());
        //专业
        examPaper.setSpecialtyCode(this.getSpecialtyCode());
        //岗位
        examPaper.setPostionCode(this.getPostionCode());
        //等级
        examPaper.setGradeCode(this.getGradeCode());
        //考试开始时间
        examPaper.setExamStartTime(this.getExamStartTime());
        //考试结束时间
        examPaper.setExamEndTime(this.getExamEndTime());
        //单选题重要数量
        examPaper.setSingleSelectionImpCount(this.getSingleSelectionImpCount());
        //多选题重要数量
        examPaper.setMultiSelectionImpCount(this.getMultiSelectionImpCount());
        //判断题重要数量
        examPaper.setJudgementImpCount(this.getJudgementImpCount());
        //考试时间
        examPaper.setExamTime(this.getExamTime());
        //总分
        examPaper.setFullScore(this.getFullScore());
        //及格分
        examPaper.setPassScore(this.getPassScore());
        //学员姓名
        examPaper.setUserName(this.getUserName());
        //分数
        examPaper.setScore(this.getScore());

        //单选答对数量
        examPaper.setSingleOkCount(this.getSingleOkCount());
        //多选答对数量
        examPaper.setMultiOkCount(this.getMultiOkCount());
        //判断答对数量
        examPaper.setJudgementOkCount(this.getJudgementOkCount());

        return examPaper;
    }

    @Override
    public String toString() {
        return "ExamPaper{" +
                "examinationPaperId='" + examinationPaperId + '\'' +
                ", leavTime='" + leavTime + '\'' +
                ", organizationId='" + organizationId + '\'' +
                ", id='" + id + '\'' +
                ", examRoomId='" + examRoomId + '\'' +
                ", userId='" + userId + '\'' +
                ", specialtyCode='" + specialtyCode + '\'' +
                ", postionCode='" + postionCode + '\'' +
                ", gradeCode='" + gradeCode + '\'' +
                ", examStartTime='" + examStartTime + '\'' +
                ", examEndTime='" + examEndTime + '\'' +
                ", singleSelectionImpCount='" + singleSelectionImpCount + '\'' +
                ", multiSelectionImpCount='" + multiSelectionImpCount + '\'' +
                ", judgementImpCount='" + judgementImpCount + '\'' +
                ", examTime='" + examTime + '\'' +
                ", fullScore='" + fullScore + '\'' +
                ", passScore='" + passScore + '\'' +
                ", userName='" + userName + '\'' +
                ", score='" + score + '\'' +
                ", resut='" + resut + '\'' +
                ", singleOkCount='" + singleOkCount + '\'' +
                ", multiOkCount='" + multiOkCount + '\'' +
                ", judgementOkCount='" + judgementOkCount + '\'' +
                '}';
    }

    public String getExaminationPaperId() {
        return examinationPaperId;
    }

    public void setExaminationPaperId(String examinationPaperId) {
        this.examinationPaperId = examinationPaperId;
    }

    public String getLeavTime() {
        return leavTime;
    }

    public void setLeavTime(String leavTime) {
        this.leavTime = leavTime;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getExamRoomId() {
        return examRoomId;
    }

    public void setExamRoomId(String examRoomId) {
        this.examRoomId = examRoomId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSpecialtyCode() {
        return specialtyCode;
    }

    public void setSpecialtyCode(String specialtyCode) {
        this.specialtyCode = specialtyCode;
    }

    public String getPostionCode() {
        return postionCode;
    }

    public void setPostionCode(String postionCode) {
        this.postionCode = postionCode;
    }

    public String getGradeCode() {
        return gradeCode;
    }

    public void setGradeCode(String gradeCode) {
        this.gradeCode = gradeCode;
    }

    public String getExamStartTime() {
        return examStartTime;
    }

    public void setExamStartTime(String examStartTime) {
        this.examStartTime = examStartTime;
    }

    public String getExamEndTime() {
        return examEndTime;
    }

    public void setExamEndTime(String examEndTime) {
        this.examEndTime = examEndTime;
    }

    public String getSingleSelectionImpCount() {
        return singleSelectionImpCount;
    }

    public void setSingleSelectionImpCount(String singleSelectionImpCount) {
        this.singleSelectionImpCount = singleSelectionImpCount;
    }

    public String getMultiSelectionImpCount() {
        return multiSelectionImpCount;
    }

    public void setMultiSelectionImpCount(String multiSelectionImpCount) {
        this.multiSelectionImpCount = multiSelectionImpCount;
    }

    public String getJudgementImpCount() {
        return judgementImpCount;
    }

    public void setJudgementImpCount(String judgementImpCount) {
        this.judgementImpCount = judgementImpCount;
    }

    public String getExamTime() {
        return examTime;
    }

    public void setExamTime(String examTime) {
        this.examTime = examTime;
    }

    public String getFullScore() {
        return fullScore;
    }

    public void setFullScore(String fullScore) {
        this.fullScore = fullScore;
    }

    public String getPassScore() {
        return passScore;
    }

    public void setPassScore(String passScore) {
        this.passScore = passScore;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getResut() {
        return resut;
    }

    public void setResut(String resut) {
        this.resut = resut;
    }

    public String getSingleOkCount() {
        return singleOkCount;
    }

    public void setSingleOkCount(String singleOkCount) {
        this.singleOkCount = singleOkCount;
    }

    public String getMultiOkCount() {
        return multiOkCount;
    }

    public void setMultiOkCount(String multiOkCount) {
        this.multiOkCount = multiOkCount;
    }

    public String getJudgementOkCount() {
        return judgementOkCount;
    }

    public void setJudgementOkCount(String judgementOkCount) {
        this.judgementOkCount = judgementOkCount;
    }
}
