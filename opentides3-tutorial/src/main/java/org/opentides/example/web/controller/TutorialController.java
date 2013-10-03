package org.opentides.example.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.opentides.bean.Comment;
import org.opentides.bean.SearchResults;
import org.opentides.bean.SystemCodes;
import org.opentides.example.bean.Ninja;
import org.opentides.example.bean.TutorialModel;
import org.opentides.example.service.NinjaService;
import org.opentides.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TutorialController {

	
	@Autowired
	private UserService userService;
	
	@Autowired
	private NinjaService ninjaService;
	
	@RequestMapping(method = RequestMethod.GET, value="/start")
	public String gettingStarted(ModelMap map){

		return "app/tutorial-getting-started";
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/project-details")
	public String projectDetails(ModelMap map){

		return "app/tutorial-project-details";
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/creating-entities")
	public String creatingEntities(ModelMap map){

		return "app/tutorial-creating-entities";
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/dao-and-service")
	public String daoAndService(ModelMap map){

		return "app/tutorial-dao-and-service";
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/crud-controller")
	public String crudController(ModelMap map){

		return "app/tutorial-crud-controller";
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/crud-view")
	public String crudView(ModelMap map){

		return "app/tutorial-crud-view";
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/tags")
	public String tagsTutorial(ModelMap map){
		
		map.addAttribute("elementList", elementList());
		map.addAttribute("tutorialModel", tutorialModel());
		map.addAttribute("results", results());
		map.addAttribute("genderList", genderList());
		map.addAttribute("brandList", brandList());
		map.addAttribute("formCommand", modelAttribute());
		
		return "app/tutorial-tags";
	}
	
	
	
	@RequestMapping(method = RequestMethod.GET, value="/defining-attributes")
	public String definingAttributes(ModelMap map){

		return "app/tutorial-defining-attributes";
	}
	
	private TutorialModel modelAttribute(){
		return new TutorialModel();
	}
	
	public List<SystemCodes> brandList() {
		List<SystemCodes> brands = new ArrayList<SystemCodes>();
		brands.add(new SystemCodes("MODEL","APPLE","Apple"));
		brands.add(new SystemCodes("MODEL","LG","LG"));
		brands.add(new SystemCodes("MODEL","HTC","HTC"));
		brands.add(new SystemCodes("MODEL","NOKIA","Nokia"));
		brands.add(new SystemCodes("MODEL","SAMSUNG","Samsung"));
		brands.add(new SystemCodes("MODEL","SONY","Sony"));
		return brands;
	}
	
	
	public List<SystemCodes> elementList() {
		List<SystemCodes> elementList = new ArrayList<SystemCodes>();
		elementList.add(new SystemCodes("Fire","",""));
		elementList.add(new SystemCodes("Water","",""));
		elementList.add(new SystemCodes("Wind","",""));
		elementList.add(new SystemCodes("Rock","",""));
		return elementList;
	}
	
	public List<SystemCodes> genderList() {
		List<SystemCodes> genderList = new ArrayList<SystemCodes>();
		genderList.add(new SystemCodes("GENDER","FEMALE","Female"));
		genderList.add(new SystemCodes("GENDER","MALE","Male"));
		genderList.add(new SystemCodes("GENDER","OTHES","Other"));
		return genderList;
	}
	
	public SearchResults<Ninja> results(){
		SearchResults<Ninja> results = new SearchResults<Ninja>(10, 10);
		for (int i = 0; i < 10; i++) {
			results.getResults().add(new Ninja());
		}
		results.setTotalResults(50L);
		
		return results;
	}
	
	public TutorialModel tutorialModel(){
		TutorialModel model = new TutorialModel();
		Comment c = new Comment();
		c.setAuthor(userService.getCurrentUser());
		c.setText("This is an example comment.");
		model.getComments().add(c);
		
		return model;
	}
	
	
	
}
