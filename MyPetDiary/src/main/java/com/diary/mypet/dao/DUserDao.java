package com.diary.mypet.dao;

import com.diary.mypet.domain.DUserVO;

// DUser ���̺� SQL �۾��ϴ� �޼ҵ� ���� �������̽�

public interface DUserDao {

	// 1. �α���
	// ����ڰ� �Է��� id�� pw�� �Ű� ������ ��ġ�ϸ� ���̺� ���� ����
	public DUserVO login(DUserVO vo);

	// 2. ȸ�� ����

	// 3. ȸ�� Ż��

	// 4. ȸ�� ���� ����
	// - ������(�̹��� & �г���) ���� �۾�
	// - ȸ�� ����(��й�ȣ) ���� �۾� -> ���̵�� ���� �Ұ�

}
