package com.diary.mypet.service;

import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.diary.mypet.domain.DiaryVO;

// ���̾ ���� �۾��� ���� �޼ҵ� ���� �������̽�
public interface DiaryService {

	// 1. ��ƺ���(���̺� �ִ� �����͸� ���̵� �������� �����ͼ� �����ֱ�, �� ��ȣ ��������)
	public List<DiaryVO> selectAllDiary(String id);

	// 2. �󼼺���(Ư�� ���̵� & ������ �۹�ȣ�� �������� �����͸� �����ͼ� �����ֱ�)
	public DiaryVO selectOneDiary(DiaryVO vo);

	// 3. �ϱ� �ۼ�(�۹�ȣ(�ڵ�), ����, ����, �̹���, ���̵�(�α����ϸ� �ڵ����� ���) �Է� �޾Ƽ� ���̺� ����
	public int insertDiary(MultipartHttpServletRequest request);

	// 4. �ϱ� ����(����, ����, �̹���) �Է� �޾Ƽ� ���̺� ����
	// �Ű� ���� MultipartHttpServletRequest�� ����
	public int updateDiary(MultipartHttpServletRequest request);

	// 4-1. ���� �������� �̵�
	public DiaryVO goUpdate(DiaryVO vo);

	// 5. �ϱ� ����(�� ��ȣ, ���̵� �������� ����)
	public int deleteDiary(DiaryVO vo);

}
