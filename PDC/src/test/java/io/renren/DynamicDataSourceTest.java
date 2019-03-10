package io.renren;

import io.renren.dynamicdatasource.DataSourceContext;
import io.renren.dynamicdatasource.DynamicDataSource;
import io.renren.modules.api.entity.UserEntity;
import io.renren.modules.api.service.UserService;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DynamicDataSourceTest {
	@Autowired
	private UserService userService;

	@Test
	public void test() {
		UserEntity user = userService.queryObject(1L);
		System.out.println(ToStringBuilder.reflectionToString(user));

		//切换数据源
		DynamicDataSource.setDataSource(DataSourceContext.FIRST.getName());
		UserEntity user2 = userService.queryObject(1L);
		System.out.println(ToStringBuilder.reflectionToString(user2));
	}

	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			Calendar cal = Calendar.getInstance();
			Date date = cal.getTime();
			System.out.println(new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss:SSS").format(date));
		}
	}
}
