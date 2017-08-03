package com.diary.mypet.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.diary.mypet.domain.DiaryVO;

// DiaryDao�� ��� �޴� Ŭ���� - ���� SQL �۾� �޼ҵ� ����
@Repository
public class DiaryDaoImpl implements DiaryDao {

	@Autowired
	private SqlSession sqlSession;

	// 1. ��ƺ���
	@Override
	public List<DiaryVO> selectAllDiary(String id) {

		return sqlSession.selectList("diary.selectAllDiary", id);
	}

	// 2. �󼼺���
	@Override
	public DiaryVO selectOneDiary(DiaryVO vo) {

		return sqlSession.selectOne("diary.selectOneDiary", vo);
	}

	// 3. ��ȸ�� ����
	@Override
	public int updateCount(DiaryVO vo) {

		return sqlSession.update("diary.updateCount", vo);
	}

	// 4. ���̾ ���
	@Override
	public int insertDiary(DiaryVO vo) {
		// TODO Auto-generated method stub
		return sqlSession.insert("diary.insertDiary", vo);
	}

	// 5. ���̾ ����
	@Override
	public int updateDiary(DiaryVO vo) {
		// TODO Auto-generated method stub
		return sqlSession.update("diary.updateDiary", vo);
	}

	// 6. ���̾ ����
	@Override
	public int deleteDiary(DiaryVO vo) {
		// TODO Auto-generated method stub
		return sqlSession.delete("diary.deleteDiary", vo);
	}

}
