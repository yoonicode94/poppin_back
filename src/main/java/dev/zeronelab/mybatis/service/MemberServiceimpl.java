package dev.zeronelab.mybatis.service;

import dev.zeronelab.mybatis.vo.MemberVO;
import dev.zeronelab.mybatis.dao.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceimpl implements MemberService {

    @Autowired
    private MemberMapper memberMapper;

    @Override
    public List<MemberVO> idCheck(MemberVO vo) throws Exception{
        return memberMapper.idCheck(vo);
    }

    @Override
    public List<MemberVO> eamilCheck(MemberVO vo) throws Exception{
        return memberMapper.eamilCheck(vo);
    }

    @Override
    public void join(MemberVO vo) throws Exception{
        memberMapper.join(vo);
    }

    public MemberVO selectMemberPW(MemberVO vo) throws Exception{
        return memberMapper.selectMemberPW(vo);
    }

    @Override
    public List<MemberVO> login(MemberVO vo) throws Exception{
        return memberMapper.login(vo);
    }

    @Override
    public List<MemberVO> jwtLogin(MemberVO vo) throws Exception{
        return memberMapper.jwtLogin(vo);
    }
}
