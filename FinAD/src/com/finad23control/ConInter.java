package com.finad23control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// ?��?��?��?��?�� 만들?�� ?��거임
// 만약 ?��?��?��?��?���? ?��?���? 만들?��?�� ?���? ?���? ?��?��?��?��?���? ?��?��?���? ?��.
public interface ConInter {
	String FinAD(HttpServletRequest rq, HttpServletResponse rs) throws Exception;
}
