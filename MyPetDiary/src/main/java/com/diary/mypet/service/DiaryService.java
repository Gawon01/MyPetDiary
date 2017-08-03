package com.diary.mypet.service;

import java.util.List;

import com.diary.mypet.domain.DiaryVO;

// ���̾ ���� �۾��� ���� �޼ҵ� ���� �������̽�
public interface DiaryService {

	// 1. ��ƺ���(���̺� �ִ� �����͸� ���̵� �������� �����ͼ� �����ֱ�, �� ��ȣ ��������)
	public List<DiaryVO> selectAllDiary(String id);

	// 2. �󼼺���(Ư�� ���̵� & ������ �۹�ȣ�� �������� �����͸� �����ͼ� �����ֱ�)
	public DiaryVO selectOneDiary(DiaryVO vo);

	// 3. �ϱ� �ۼ�(�۹�ȣ(�ڵ�), ����, ����, �̹���, ���̵�(�α����ϸ� �ڵ����� ���) �Է� �޾Ƽ� ���̺� ����
	public int insertDiary(DiaryVO vo);

	// 4. �ϱ� ����(����, ����, �̹���) �Է� �޾Ƽ� ���̺� ����
	public int updateDiary(DiaryVO vo);

	// 5. �ϱ� ����(�� ��ȣ, ���̵� �������� ����)
	public int deleteDiary(DiaryVO vo);

}
