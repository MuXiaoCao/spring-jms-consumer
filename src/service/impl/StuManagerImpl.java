package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.johnyu.util.BaseUtil;
import dao.StuDao;
import dao.impl.StuDaoImpl;
import service.StuManager;
import vo.Student;
@Service("sm")
public class StuManagerImpl implements StuManager {
	@Autowired(required=true)
	private StuDao sd;
	@Override
	public Student login(String xh, String psd) {
		
		return sd.findStu(xh,BaseUtil.JohnMd(psd, "md5"));
	}

	@Override
	public int regist(Student s) {
		s.setPsd(BaseUtil.JohnMd(s.getPsd(), "md5"));
		return sd.addStu(s);
	}

}
