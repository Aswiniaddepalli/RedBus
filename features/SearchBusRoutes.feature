Feature: Search for bus routes
As a user
  I want to search for bus routes
  So that I can find available routes between two cities 
  @Citynames
Scenario: Search for a route between two cities
         Given I am on the Red Bus application
         When I want to give  two cities names
         Then I want to give the date
    @filters
Scenario: list of different types of filters
				 Given I am on the Red Bus application
         When I want to give  two cities names
         And I want to give the date
         Then I want to get the different filters names
     @Tsrtc    
Scenario: checking the TSRTC Buses
				 Given I am on the Red Bus application
         When I want to give  two cities names
         And I want to give the date
         And I click on tsrtc buses
         Then I am able to see the list of buses
      @Apsrtc
Scenario: cheking the APSRTC buses
				 Given I am on the Red Bus application
         When I want to give  two cities names
         And I want to give the date
         And I want to click on apsrtc buses
         Then I am able to see the list of buses
				@ApplyingFilter
Scenario: giving of filter
				 Given I am on the Red Bus application
         When I want to give  two cities names
         And I want to give the date
         And I want click on filter 
         Then It gives available buses

         
         