package com.example.chain.demo.old;


import com.example.chain.demo.bean.Member;
import com.example.chain.demo.util.StringUtils;

public class MemberService {

    public static void main(String[] args) {
        MemberService service = new MemberService();
        service.login("jake", "123");
    }

    public void login(String loginName, String loginPass) {
        if (StringUtils.isEmpty(loginName) || StringUtils.isEmpty(loginPass)) {
            System.err.println("用户名和密码为空");
            return;
        }
        System.out.println("用户名和密码不为空，可以往下执行");

        Member member = checkExists(loginName, loginPass);

        System.out.println("登录成功！");

        if (!"管理员".equals(member.getRoleName())) {
            System.err.println("您不是管理员，没有操作权限");
            return;
        }
        System.out.println("允许操作");
    }

    private Member checkExists(String loginName, String loginPass) {
        Member member = new Member(loginName, loginPass);
        member.setRoleName("管理员");
        return member;
    }
}
