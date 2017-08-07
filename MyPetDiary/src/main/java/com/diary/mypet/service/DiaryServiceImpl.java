package com.diary.mypet.service;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

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

	// �󼼺��� �޼ҵ� - id�� �� ��ȣ�� �������� ���̺��� �����͸� ������
	// �׸��� ��ȸ�� 1 ����
	@Override
	public DiaryVO selectOneDiary(DiaryVO vo) {
		// 1) ��ȸ�� 1 ����
		dao.updateCount(vo);

		// 2) �� ��ȣ & ���̵� ���� ������ ����
		return dao.selectOneDiary(vo);
	}

	// ���̾ �ۼ��ϴ� �޼ҵ�
	@Override
	public int insertDiary(MultipartHttpServletRequest request) {

		// 1) �ϱ� �ۼ� ������ �� ��������
		// ���̵�� �ϴ� ����Ʈ ��
		String id = "root";
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		// 2) Dao �޼ҵ忡�� ����� �Ű����� ����
		DiaryVO vo = new DiaryVO();
		vo.setId(id);
		vo.setTitle(title);
		vo.setContent(content);

		// 3) �̹��� ���� ��������
		// (1) ������ ���� ��������
		MultipartFile image = request.getFile("image");
		// (2) ���� ������ ���丮�� ������ �������� -> servlet ������ 2.5 �̻� �̾�� ��
		String uploadPath = request.getServletContext().getRealPath("/diaryimage");
		// (3) �ߺ����� �ʴ� ���ڿ� ����
		UUID uid = UUID.randomUUID();
		String filename = image.getOriginalFilename();

		if (filename != null) {
			filename = uid + filename;
			// ����� ���� ��� ����
			String filepath = uploadPath + "\\" + filename;
			// ���� ���ε�
			File file = new File(filepath);
			try {
				image.transferTo(file);

			} catch (Exception e) {
				e.printStackTrace();
			}
			// ���̺� ���� �̸� ����
			vo.setImage(filename);

		} else {

			// ����ڰ� ������ ������ ���� ��� null�� ǥ�� �Ǵ� ����Ʈ �̹��� ���
			vo.setImage("");

		}
		// 4) Dao �޼ҵ� ȣ��
		return dao.insertDiary(vo);
	}

	// ���� �������� �̵� - id�� �� ��ȣ �޾Ƽ� ������ ����
	@Override
	public DiaryVO goUpdate(DiaryVO vo) {
		// selectOneDiary ����
		return dao.selectOneDiary(vo);
	}

	// �� ���� -> �� �Է°� �Ȱ���
	@Override
	public int updateDiary(MultipartHttpServletRequest request) {
		// 1) �ϱ� �ۼ� ������ �� ��������
		String id = request.getParameter("id");
		int no = Integer.parseInt(request.getParameter("no"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		// 2) Dao �޼ҵ忡�� ����ϱ� ���� VO �����ͼ� �� ����
		DiaryVO vo = new DiaryVO();
		vo.setNo(no);
		vo.setTitle(title);
		vo.setContent(content);
		vo.setId(id);

		// 3) �̹��� ���� ��������
		// ������ �̹��� ���� ������
		MultipartFile image = request.getFile("image");
		// ����� ���� ������ ���丮�� ���� ��� ��������
		String uploadPath = request.getServletContext().getRealPath("/diaryimage");
		// ���Ϲ����� ���ڿ� ����
		UUID uid = UUID.randomUUID();
		// ��ϵ� ���� �̸� ��������
		String filename = image.getOriginalFilename();

		if (filename != null) {
			// ���� ���ڿ� & ���� �̸� ��ġ��
			filename = uid + filename;
			// ������ ���� ��� ����
			String filepath = uploadPath + "\\" + filename;
			// ���� ��� ����
			File file = new File(filepath);
			try {
				// �̹��� ������ ���ε�
				image.transferTo(file);

			} catch (Exception e) {
				e.printStackTrace();
			}
			// ���̺� ���� �̸� ����
			vo.setImage(filename);

		} else {
			vo.setImage("");
		}

		// 4) Dao ȣ��
		return dao.updateDiary(vo);
	}

	// �� ��ȣ ���̵� �´� ������ ����
	@Override
	public int deleteDiary(DiaryVO vo) {

		return dao.deleteDiary(vo);
	}

}
