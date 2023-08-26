#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Puchase the order from EComerrce Wabsite
  I want to use this template for my feature file
  
  Background:
  Give I landed on Ecomerce page

  @tag2
  Scenario Outline: Positive Test of Submitting the order
    Given Logged in with username <name> and password<password>
    When I add product <productname> to cart
    And Checkout <productname> and submit the order
    Then "THANYOU FOR THE ORDER" is displayed on confirmationpage

    Examples: 
      | name  | password | productname  |
      | name1 |     5 | success |
    