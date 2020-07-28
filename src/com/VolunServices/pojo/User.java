package com.VolunServices.pojo;

public class User {
    private Integer uid;

    private String uname;

    private String upassword;

    private Integer identity;

    private String nowaddress;
    
    private Userinfo userinfor;

	public Userinfo getUserinfor() {
		return userinfor;
	}

	public void setUserinfor(Userinfo userinfor) {
		this.userinfor = userinfor;
	}

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname == null ? null : uname.trim();
    }

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword == null ? null : upassword.trim();
    }

    public Integer getIdentity() {
        return identity;
    }

    public void setIdentity(Integer identity) {
        this.identity = identity;
    }

    public String getNowaddress() {
        return nowaddress;
    }

    public void setNowaddress(String nowaddress) {
        this.nowaddress = nowaddress == null ? null : nowaddress.trim();
    }

    
    
	public User() {
		super();
	}
	
	

	public User(Integer uid, Integer identity) {
		super();
		this.uid = uid;
		this.identity = identity;
	}
	
	

	public User(Integer uid, String upassword) {
		super();
		this.uid = uid;
		this.upassword = upassword;
	}

	public User(Integer uid, String uname, String upassword, Integer identity, String nowaddress, Userinfo userinfor) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.upassword = upassword;
		this.identity = identity;
		this.nowaddress = nowaddress;
		this.userinfor = userinfor;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", upassword=" + upassword + ", identity=" + identity
				+ ", nowaddress=" + nowaddress + "]";
	}
    
}