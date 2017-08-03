package com.diary.mypet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diary.mypet.dao.DiaryDao;

// DiaryService �޼ҵ� ���� ���� Ŭ����

import com.diary.mypet.domain.DiaryVO;

@Service
public class DiaryServiceImpl implements DiaryService {

	@Autowired
	private DiaryDao dao;

	// ��ƺ��� �޼ҵ� - id�� �������� ���̺� �ִ� �����͸� ������
	@Override
	public List<DiaryVO> selectAllDiary(String id) {

		return dao.selectAllDiary(id);
	}

	@Override
	public DiaryVO selectOneDiary(DiaryVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	// ���̾ �ۼ��ϴ� �޼ҵ�
	@Override
	public int insertDiary(DiaryVO vo) {
		// 1) �Է¿� �ʿ��� ���� : #{title},#{content},#{id} --> �ϴ� �̹��� �Է� ����
		// ���̵�� �ϴ� �׳� �Է� - ���߿� ȸ�� ���̺� ���� �� ����
		// ���̵� ����
		String id = "root";
		vo.setId(id);
		// 2) ����
		return dao.insertDiary(vo);
	}

	@Override
	public int updateDiary(DiaryVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteDiary(DiaryVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
