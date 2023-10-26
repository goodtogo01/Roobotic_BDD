
Feature: Robotic page I will perform to validate all possible functionalities include Logins

@LoginFunctionalities
Scenario: login with Valid credentias
		Given User already on login page with Valid credentias
    Then Enter Valid "<userName>" and "<password>" in appropriate field
    And Click on login button
    Then Validate Display User name on the home page
    
   Examples:
    |userName|password|
    |maria|thoushallnotpass|
		

@SalsePersonDetails					  
Scenario: Validat Actual Sales functionalities againest of targeted salse
		Given I enter Sales person data with "<firstN>" and "<lastN>" and Actual Sales amount as "<salseAmount>"
		When I click on Submit button
		Then I am able to see the details appeares 
	
	Examples:
		|firstN|lastN|salseAmount|
		|Miraz|Zaman|2001|
		|Minhaz|Zaman|3200|
		|Liza|Zaman|950|
		|Khosruz|Zaman|3690|


@TergtedSalse		
Scenario: Validate tergated salse
		Given Targated salse validation 
		When I click on show performance
		Then I must see "<message>" particuler Message for me based on my salse 
	 Examples:
 |message|
 |Oh dear.|
 |Well. It was a nice attempt. I guess?|
 |Hmm. Did not quite make it.|
 |The boss wants to see you...|
	 
		@CloseCurrentBrowser					  
Scenario: Close browser
		Given I am completed my validation and I will close the current browser


