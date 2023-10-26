Feature: Robotic page I will perform to validate all possible functionalities include Logins


Background:

  	When User already on login page with Valid credentias
    Then Enter Valid "<userName>" and "<password>" in appropriate field
    And Click on login button
    Then Validate Display User name on the home page
    
    Examples:
		|userName|password|
		|maria|thoushallnotpass|
						  
	Scenario:  Validat Actual Sales functionalities againest of targeted salse
	Given I am on homepage
		When I enter Sales person data with "<firstN>" and "<lastN>" and Actual Sales amount as "<salseAmount>"
		Then I am able to see the details appeares Once I click on Submit button
	
Examples:
	|firstN|lastN|salseAmount|
	|Miraz|Zaman|3500|