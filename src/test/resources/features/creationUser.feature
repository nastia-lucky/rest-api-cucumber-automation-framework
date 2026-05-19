Feature: User creation

  @smoke @api @regression
  Scenario Outline: check users with valid data can be created
    When I create a user with firstName "<firstName>", lastName "<lastName>", email "<email>", password "<password>", phone "<phone>", userStatus <userStatus>
    Then I check status code as expected 200 for user
    Then I can get created user by username
    Then  I check got user the same as created user
    Then I delete a user

    Examples:
      | firstName | lastName | email         | password | phone  | userStatus |
      | John      | Doe      | john@mail.com | pass123  | 123456 | 1          |
      | Anna      | Smith    | anna@mail.com | pass456  | 654321 | 2          |

  @api @regression
  Scenario Outline: check user with valid data can be deleted
    When I create a user with firstName "<firstName>", lastName "<lastName>", email "<email>", password "<password>", phone "<phone>", userStatus <userStatus>
    Then I can get created user by username
    Then I delete a user
    Then I check status code as expected 200 for user
    Then I check I can't get user by userName

    Examples:
      | firstName | lastName | email         | password | phone  | userStatus |
      | John      | Doe      | john@mail.com | pass123  | 123456 | 1          |
      | Anna      | Smith    | anna@mail.com | pass456  | 654321 | 2          |


  @smoke @api @regression
  Scenario Outline: check user with valid data can be updated
    When I create a user with firstName "<firstName>", lastName "<lastName>", email "<email>", password "<password>", phone "<phone>", userStatus <userStatus>
    Then I can get created user by username
    Then I update the user
      | firstName | lastName | email              | password | phone  | userStatus |
      | Micha     | Sopotd   | email@emailupd.com | password | 677776 | 5          |
    Then I check status code as expected 200 for user
    Then I check got user the same as updated user
    Then I delete a user

    Examples:
      | firstName | lastName | email         | password | phone  | userStatus |
      | John      | Doe      | john@mail.com | pass123  | 123456 | 1          |
      | Anna      | Smith    | anna@mail.com | pass456  | 654321 | 2          |


    
    
    