package com.devicespringboot.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.devicespringboot.dto.EmployeeDTO;
import com.devicespringboot.service.IEmployeeService;
import com.devicespringboot.service.implementation.RoleService;

import antlr.collections.List;

@Controller
@RequestMapping(value = "employee")
public class EmployeeController {
	@Autowired
	private IEmployeeService employeeService;

	@Autowired
	private RoleService roleService;

	@GetMapping(value = { "/edit" })
	public String getAddView(Model model) {
		model.addAttribute("employee", new EmployeeDTO());
		model.addAttribute("roles", roleService.findAll());

		return "employee/edit";
	}

	@GetMapping(value = { "/edit/{id}" })
	public String getEditView(@PathVariable Map<String, String> pathVariableMap, Model model) {
		model.addAttribute("employee", employeeService.findOneById(
				Long.parseLong(pathVariableMap.get("id"))));
		model.addAttribute("roles", roleService.findAll());

		return "employee/edit";
	}

	@GetMapping
	public String getListView(Model model,@SortDefault(sort = "id", direction = Direction.DESC) Sort sort) {
		
		return "employee/list";
	}
	
	@GetMapping("/sort")
	public String getSortedListView(Model model) {
		
		model.addAttribute("totalPages",10);
		return "employee/list";
	}

	@ResponseBody
	@PostMapping(value = "/edit")
	public Long add(@RequestBody EmployeeDTO employee) {
		return employeeService.save(employee).getId();
	}

	@ResponseBody
	@DeleteMapping(value = "/delete/{id}")
	public void delete(@PathVariable(name = "id") String id) {
		if (!employeeService.existsById(Long.valueOf(id))) {
			employeeService.delete(Long.parseLong(id));
		}
	}

//	
//	@RequestMapping(value = "/login", method = RequestMethod.GET)
//	public ModelAndView loginPage(HttpServletRequest request) {
//		ModelAndView mav = new ModelAndView("web/login.jsp");
//		if (request.getParameter("message") != null) {
//			if (request.getParameter("message").equals("success_sign_in")) {
//				mav.addObject("message", "Tài khoản đã đăng kí thành công");
//			}
//		}
//		if (request.getParameter("message") != null) {
//			Map<String, String> message = messageUtils.getMessage(request.getParameter("message"));
//			mav.addObject("message", message.get("message"));
//			mav.addObject("alert", message.get("alert"));
//		}
//		return mav;
//	}
//
//	@RequestMapping(value = "/logout", method = RequestMethod.GET)
//	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		if (authentication != null) {
//			new SecurityContextLogoutHandler().logout(request, response, authentication);
//		}
//		return "redirect:/login";
//	}
//
//	@RequestMapping(value = "/sign-in", method = RequestMethod.GET)
//	public ModelAndView signInPage(HttpServletRequest request) {
//		ModelAndView mav = new ModelAndView("web/sign_in.jsp");
//		mav.addObject("model", new UserDTO());
//		if (request.getParameter("message") != null) {
//			if (request.getParameter("message").equals("account_exist")) {
//				mav.addObject("message", "Tài khoản đã tồn tại");
//				
//			}
//		}
//		return mav;
//	}
//	
//	@RequestMapping(value = "/sign-in", method = RequestMethod.POST)
//	public String signInPage(@ModelAttribute(value = "model") UserDTO user,BindingResult result) {
//		userValidator.validate(user, result);
//		if(result.hasErrors()) {
//			return "web/sign_in.jsp";
//		}else {
//			userService.insert(user);
//			return "redirect:/login?message=success_sign_in";
//		}
//		
//	}
//
//	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
//	public ModelAndView accessDenied() {
//		return new ModelAndView("redirect:/login?accessDenied");
//	}

//	 @GetMapping("/customer/list")
//	    public String getCustomerListView(Model model,HttpServletRequest request){
//	        if(request.getAttribute("search")!=null){
//	            System.out.println(request.getAttribute("search"));
//	        }
//	        Pageable pageable = PageRequest.of(1-1,5);
//	        List<CustomerDTO> dtos = customerService.findAllPagination(pageable);
//
//	        model.addAttribute("customers",dtos);
//
//	        int totalPages =(int) Math.ceil((double) customerService.totalItem()/5);
//	        model.addAttribute("url","/customer/list/");
//	        List<CityDTO> cityList = cityService.findAll();
//	        model.addAttribute("cityList",cityList);
//
//	        model.addAttribute("page",1);
//	        model.addAttribute("totalPages",totalPages);
//
//	        return "list";
//	    }
//	    @RequestMapping(value = "/customer/list/{page}",method = RequestMethod.GET)
//	    public String getCustomerListPagination(@PathVariable(name = "page",required = false) int page,Model model) {
//	        Pageable pageable = PageRequest.of(page-1,5);
//	        List<CustomerDTO> dtos = customerService.findAllPagination(pageable);
//	        int totalPages =(int) Math.ceil((double) customerService.totalItem()/5);
//	        model.addAttribute("url","/customer/list/");
//	        model.addAttribute("page",page);
//	        model.addAttribute("totalPages",totalPages);
//	        model.addAttribute("customers",dtos);
//	        return "sub_table";
//	    }
//
//	    @RequestMapping(value = "/customer/search-id",method = RequestMethod.GET)
//	    public String getSearchByCustomerId(@RequestParam("id") String search,Model model) {
//	        List<CustomerDTO> customers = new ArrayList<>();
//	        CustomerDTO customerDTO =  customerService.findById(Long.parseLong(search));
//	        customers.add(customerDTO);
//	        model.addAttribute("customers",customers);
//	        return "sub_table";
//	    }
//
//	    @RequestMapping(value = "/customer/search-name-or-city/{page}",method = RequestMethod.GET)
//	    public String getSearchByCustomerNameAndCityPaginiation(@PathVariable(name = "page",required = false) int page,
//	                                          @RequestParam("searchName") String searchName,
//	                                          @RequestParam("searchCity") String cityId, Model model) {
//	        Pageable pageable = PageRequest.of(page-1,5);
//	        List<CustomerDTO> dtos = new ArrayList<>();
//	        if(!searchName.isEmpty() && cityId.isEmpty()){
//	            dtos =  customerService.findAllByCustomerName(searchName,pageable);
//	            int totalPages =(int) Math.ceil((double) customerService.totalItemCustomerName(searchName)/5);
//	            model.addAttribute("totalPages",totalPages);
//	        }else if(!searchName.isEmpty() && !cityId.isEmpty()){
//	            dtos =  customerService.findAllByCustomerNameAndCity(searchName,Long.parseLong(cityId),pageable);
//	            int totalPages =(int) Math.ceil((double) customerService.totalItemCustomerNameAndCity(searchName,Long.parseLong(cityId))/5);
//	            model.addAttribute("totalPages",totalPages);
//	        }
//	        model.addAttribute("url","/customer/search-name-or-city/");
//	        model.addAttribute("page",page);
//	        model.addAttribute("customers",dtos);
//	        return "sub_table";
//	    }
//
//	    @RequestMapping(value = "/customer/search-name-or-city",method = RequestMethod.GET)
//	    public String getSearchByCustomerNameAndCity(@RequestParam("searchName") String searchName,
//	                                                 @RequestParam("searchCity") String cityId, Model model) {
//	        Pageable pageable = PageRequest.of(0,5);
//	        List<CustomerDTO> dtos = new ArrayList<>();
//	        if(!searchName.isEmpty() && cityId.isEmpty()){
//	            dtos =  customerService.findAllByCustomerName(searchName,pageable);
//	            int totalPages =(int) Math.ceil((double) customerService.totalItemCustomerName(searchName)/5);
//	            model.addAttribute("totalPages",totalPages);
//	        }else if(!searchName.isEmpty() && !cityId.isEmpty()){
//	            dtos =  customerService.findAllByCustomerNameAndCity(searchName,Long.parseLong(cityId),pageable);
//	            int totalPages =(int) Math.ceil((double) customerService.totalItemCustomerNameAndCity(searchName,Long.parseLong(cityId))/5);
//	            model.addAttribute("totalPages",totalPages);
//	        }
//	        model.addAttribute("url","/customer/search-name-or-city/");
//	        model.addAttribute("page",1);
//	        model.addAttribute("customers",dtos);
//	        return "pagination";
//	    }
//
//
//
//
//
//	    @RequestMapping(value = {"/customer/edit","/customer/edit/{id}"}, method = RequestMethod.GET)
//	    public String getCustomerUpdatingView(@PathVariable Map<String, String> pathVariablesMap, Model model){
//	        if(pathVariablesMap.containsKey("id")){
//	            CustomerDTO customer = customerService.findById(Long.parseLong(pathVariablesMap.get("id")));
//	            model.addAttribute("customer",customer);
//	        }else{
//	            model.addAttribute("customer", new CustomerDTO());
//	        }
//	        return "add";
//	    }
}
