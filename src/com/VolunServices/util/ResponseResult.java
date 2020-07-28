package com.VolunServices.util;

import java.io.Serializable;

public class ResponseResult implements Serializable {
	private static final long serialVersionUID = 4633451373316892528L;

	// ��Ӧҵ��״̬
	public int status = 200;

	// ��Ӧ��Ϣ
	public String msg = "�����ɹ�";

	// ��Ӧ����
	public Object data = null;

	/**
	 * 
	 * <p>
	 * Title: ��Ӧʧ��
	 * </p>
	 * 
	 * @return ResponseResult
	 */
	public static ResponseResult fail() {
		return fail("����ʧ��");
	}

	/**
	 * 
	 * <p>
	 * Title: ��Ӧʧ�ܣ������Զ�����Ӧ��Ϣl
	 * </p>
	 * 
	 * @param msg ��Ҫ�Զ������Ӧ��Ϣ
	 * @return ResponseResult
	 */
	public static ResponseResult fail(String msg) {
		return bulid(500, msg, null);
	}

	/**
	 * 
	 * <p>
	 * Title: �ɹ����Ҵ������ݣ������Զ�����Ӧ��Ϣ����
	 * </p>
	 * 
	 * @param msg  ��Ӧ��Ϣ����
	 * @param data ��Ӧ����
	 * @return ResponseResult
	 */
	public static ResponseResult ok(String msg, Object data) {
		return bulid(200, msg, data);
	}

	/**
	 * 
	 * <p>
	 * Title: �ɹ����Ҵ������ݣ����ǲ��Զ�����Ϣ
	 * </p>
	 * 
	 * @param data ��Ҫ���ݵ�����
	 * @return ResponseResult
	 */
	public static ResponseResult ok(Object data) {
		return ok("�����ɹ�", data);
	}

	/**
	 * 
	 * <p>
	 * Title: �ɹ�����������Ϣ��Ҳ���Զ�����Ϣ
	 * </p>
	 * 
	 * @return ResponseResult
	 */
	public static ResponseResult ok() {
		return ok("�����ɹ�", null);
	}

	/**
	 * '
	 * 
	 * <p>
	 * Title: �ɹ������������ݣ�������Ҫ�Զ���Ӧ��Ϣ
	 * </p>
	 * 
	 * @param msg ��Ҫ�Զ������Ӧ��Ϣ
	 * @return ResponseResult
	 */
	public static ResponseResult ok(String msg) {
		return ok(msg, null);
	}

	/**
	 * 
	 * <p>
	 * Title: �Զ�����Ӧ�ṹ
	 * </p>
	 * 
	 * @param status ��Ӧ״̬
	 * @param msg    ��Ӧ��Ϣ
	 * @param data   ��Ӧ����
	 * @return ResponseResult
	 */
	public static ResponseResult bulid(int status, String msg, Object data) {
		return new ResponseResult(status, msg, data);
	}

	
	public ResponseResult() {
		super();
	}

	/**
	 *
	 * @param status
	 * @param msg
	 * @param data
	 */
	public ResponseResult(int status, String msg, Object data) {
		super();
		this.status = status;
		this.msg = msg;
		this.data = data;
	}

	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * @return the data
	 */
	public Object getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(Object data) {
		this.data = data;
	}

	/*
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ResponseResult [status=" + status + ", msg=" + msg + ", data=" + data + "]";
	}
}
