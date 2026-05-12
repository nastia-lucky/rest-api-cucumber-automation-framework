Feature: Pet creation

  @smoke @api @regression
  Scenario Outline: check pet with valid data can be created
    When I create a pet with name "<name>", status "<status>", categoryId <categoryId>, categoryName "<categoryName>", tagId <tagId>, tagName "<tagName>", photoURL "<photoURL>"
    Then I check status code as expected 200
    Then I check by getting pet I get expected code 200
    Then I check got cat the same as created cat
    Then I delete a pet

    Examples:
      | name     | status   | categoryId | categoryName | tagId | tagName | photoURL       |
      | my Pet   | accepted | 1          | Category 2   | 15    | tag 1   | hfrhr          |
      | my Pet 2 | rejected | 2          | Category 3   | 667   | tag 2   | tfvnfhvbhgName |

  @smoke @api @regression
  Scenario: check pet with valid data can be updated
    When I create a pet with name "my Pet", status "accepted", categoryId 1, categoryName "Category 2", tagId 15, tagName "tag 1", photoURL "hfrhr"
    Then I check I can update created pet with name "my Pet 2", status "rejected", categoryId 2, categoryName "Category 3", tagId 667, tagName "tag 2", photoURL "tfvnfhvbhgName"
    Then I check got cat the same as updated cat
    Then I delete a pet


  @api @regression
  Scenario Outline: check pet can be deleted
    When I create a pet with name "<name>", status "<status>", categoryId <categoryId>, categoryName "<categoryName>", tagId <tagId>, tagName "<tagName>", photoURL "<photoURL>"
    Then I delete a pet
    Then I check status code as expected 200
    Then I check by getting pet I get expected code 404

    Examples:
      | name     | status   | categoryId | categoryName | tagId | tagName | photoURL       |
      | my Pet   | accepted | 1          | Category 2   | 15    | tag 1   | hfrhr          |
      | my Pet 2 | rejected | 2          | Category 3   | 667   | tag 2   | tfvnfhvbhgName |




