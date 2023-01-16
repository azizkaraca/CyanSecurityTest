Feature: Status Code Functionality

  Scenario Outline: Status Code Control

    Given Navigate to Status Code Page

    When User Click the Code
      | <codeLoc> |
    Then Verify User reach the Clicked Code
      | <successCodeLoc> | <CodeVerify> |

    Examples:
      | codeLoc | successCodeLoc | CodeVerify |
      | code200 | success200     | 200        |
      | code301 | success301     | 301        |
      | code404 | success404     | 404        |
      | code500 | success500     | 500        |