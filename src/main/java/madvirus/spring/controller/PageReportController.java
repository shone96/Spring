package madvirus.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageReportController {
	
	@RequestMapping("/pageReport")
	public ModelAndView pdfReport() {
		List<PageRank> pageRanks = new ArrayList<PageRank>(); //pageRankspdf 라는 PageRank자바빈 리스트에 내용을 넣음
		pageRanks.add(new PageRank(1, "/bbs/mir2/list"));//PageRank자바빈 rank, page에 값이 들어감
		pageRanks.add(new PageRank(2, "/bbs/mir3/list"));
		pageRanks.add(new PageRank(3, "/bbs/changchun2/list"));
		return new ModelAndView("pageReport", "pageRanks", pageRanks);
	}
	
	@RequestMapping("/pageXmlReport")
	public ModelAndView xmlReport() {
		List<PageRank> pageRanks = new ArrayList<PageRank>();
		pageRanks.add(new PageRank(1, "/bbs/mir2/list"));
		pageRanks.add(new PageRank(2, "/bbs/mir3/list"));
		pageRanks.add(new PageRank(3, "/bbs/changchun2/list"));
		return new ModelAndView("pageXmlReport", "report", new PageRankReport(pageRanks));
	}
	
	@RequestMapping("/pageJsonReport")
	public ModelAndView jsonReport() {
		List<PageRank> pageRanks = new ArrayList<PageRank>();
		pageRanks.add(new PageRank(1, "/bbs/mir2/list"));
		pageRanks.add(new PageRank(2, "/bbs/mir3/list"));
		pageRanks.add(new PageRank(3, "/bbs/changchun2/list"));
		return new ModelAndView("pageJsonReport", "report", new PageRankReport(pageRanks));
	}
}
