package com.diary.mypet.dao;

import java.util.List;

import com.diary.mypet.domain.DiaryVO;

// Diary ���̺� SQL �޼ҵ� ������ �������̽�
public interface DiaryDao {

	// 1. ��ƺ���(���̺� �ִ� �����͸� ���̵� �������� �����ͼ� �����ֱ�, �� ��ȣ ��������)
	public List<DiaryVO> selectAllDiary(String id);

	// 2. �󼼺���(Ư�� ���̵� & ������ �۹�ȣ�� �������� �����͸� �����ͼ� �����ֱ�)
	public DiaryVO selectOneDiary(DiaryVO vo);

	// 2-1) �󼼺��� �� ��ȸ�� 1 ����
	public int updateCount(DiaryVO vo);

	// 3. �ϱ� �ۼ�(�۹�ȣ(�ڵ�), ����, ����, �̹���, ���̵�(�α����ϸ� �ڵ����� ���) �Է� �޾Ƽ� ���̺� ����
	public int insertDiary(DiaryVO vo);

	// 4. �ϱ� ����(����, ����, �̹���) �Է� �޾Ƽ� ���̺� ����
	public int updateDiary(DiaryVO vo);

	// 5. �ϱ� ����(�� ��ȣ, ���̵� �������� ����)
	public int deleteDiary(DiaryVO vo);
}
