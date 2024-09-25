package dev.zeronelab.mybatis.dao;

import dev.zeronelab.mybatis.vo.MemberVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {

    public List<MemberVO> idCheck(MemberVO vo) throws Exception;
    public List<MemberVO> eamilCheck(MemberVO vo) throws Exception;
    public void join(MemberVO vo) throws Exception;
    public MemberVO selectMemberPW(MemberVO vo) throws Exception;
    public List<MemberVO> login(MemberVO vo) throws Exception;
    public List<MemberVO> jwtLogin(MemberVO vo) throws Exception;

    public Long findMno(String bwriter) throws Exception;

}
