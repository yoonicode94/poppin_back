package dev.zeronelab.mybatis.service;

import dev.zeronelab.mybatis.vo.MemberVO;

import java.util.List;

public interface MemberService {

    public List<MemberVO> idCheck(MemberVO vo) throws Exception;
    public List<MemberVO> eamilCheck(MemberVO vo) throws Exception;
    public void join(MemberVO vo) throws Exception;
    public MemberVO selectMemberPW(MemberVO vo) throws Exception;
    public List<MemberVO> login(MemberVO vo) throws Exception;
    public List<MemberVO> jwtLogin(MemberVO vo) throws Exception;

}
