package com.finad23.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// �������̽� ����� �а���
// ���� �������̽��� ������ ������ �ϸ� ���� �������̽��� �����ϸ� ��.
public interface ConInter {
	String FinAD(HttpServletRequest rq, HttpServletResponse rs) throws Exception;
}
