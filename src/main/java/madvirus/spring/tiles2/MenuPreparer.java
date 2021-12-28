package madvirus.spring.tiles2;

import java.util.ArrayList;
import java.util.List;

import org.apache.tiles.AttributeContext;
import org.apache.tiles.context.TilesRequestContext;
import org.apache.tiles.preparer.ViewPreparer;
//SPRING 빈
public class MenuPreparer implements ViewPreparer{
	//ViewPreparer 인터페이스의 execute() 메서드는 TilesRequestContext나 AttributeContext를 이용해서 여러 페이지에 적용되는 영역에서 필요로 하는 데이터를 전달할 수 있다.
	@Override
	public void execute(TilesRequestContext tilesContext, AttributeContext attributeContext) {
		List<String> menuList = new ArrayList<String>();
		menuList.add("홈");
		menuList.add("로그인");
		menuList.add("회원가입");
		tilesContext.getRequestScope().put("menuList", menuList);
	}

}
