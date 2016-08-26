package com.ota.controller;

import java.io.IOException;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.ota.DAO.TestDescDAO;
import com.ota.model.Candidate;

@org.springframework.stereotype.Controller
@RequestMapping("/")
public class Controller {
	@Autowired
	private TestDescDAO testDescDAO;;

	@RequestMapping("test")
	public String displayTestMethod(Model modelAndView) {
		System.out.println("Hello call reached to Spring bool controller");
		String testDesc = testDescDAO.getTestDesc().get(0).getTestDescription();
		System.out.println(testDesc);
		modelAndView.addAttribute("testDesc", testDesc);
		modelAndView.addAttribute("candidate", new Candidate());
		return "testView";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "test2", method = RequestMethod.GET)
	public String testNew(@RequestParam String code, Model modelAndView) throws JsonParseException, IOException {

		RestTemplate restTemplate = new RestTemplate();
		RestTemplate restTemplate2 = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		HttpHeaders headers2 = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		String req = "code=" + code + "&"
				+ "client_id=487338188162-86agt5l55fj630qomutjh430b9vjl2ek.apps.googleusercontent.com&"
				+ "client_secret=5xukWQZS-_bpVwqJA324lblf&" + "redirect_uri=http://localhost:8080/test2&"
				+ "grant_type=authorization_code";
		System.out.println(req);
		HttpEntity<String> request = new HttpEntity<String>(req, headers);

		HashMap<String, String> token = restTemplate
				.postForEntity("https://www.googleapis.com/oauth2/v4/token", request, HashMap.class).getBody();

		String newToken = token.get("access_token");
		System.out.println(newToken);

		headers2.add("Authorization", "Bearer " + newToken);
		HttpEntity<String> ent = new HttpEntity<>(headers2);
		HashMap<String, String> res = restTemplate2
				.exchange("https://www.googleapis.com/blogger/v3/blogs/1595984422812577917", HttpMethod.GET, ent,
						HashMap.class)
				.getBody();
		modelAndView.addAttribute("token", res.get("name"));

		return "candidateTestView";
	}

	@RequestMapping(value = "candidate", method = RequestMethod.POST)
	public String validateCandidate(@ModelAttribute Candidate candidate, Model model) {

		RestTemplate restTemplate = new RestTemplate();

		return restTemplate.getForObject(
				"https://accounts.google.com/o/oauth2/v2/auth?scope=https://www.googleapis.com/auth/blogger&state=security_token12345678&redirect_uri=http://localhost:8080/test2&response_type=code&client_id=487338188162-86agt5l55fj630qomutjh430b9vjl2ek.apps.googleusercontent.com",
				String.class);

		// System.out.println(candidate.getUsername());
		// System.out.println(candidate.getPassword());
		//
		// Candidate candidateFromDatabase =
		// testDescDAO.getCandidate(candidate.getUsername(),
		// candidate.getPassword());
		// if (candidateFromDatabase != null &&
		// candidateFromDatabase.getUsername().equals(candidate.getUsername()))
		// {
		// model.addAttribute("candidate", candidateFromDatabase);
		// return "candidateTestView";
		// } else {
		//
		// model.addAttribute("errorMessage", "Invalid Username or Password");
		// model.addAttribute("testDesc",
		// testDescDAO.getTestDesc().get(0).getTestDescription());
		// return "testView";
		// }
	}
}
