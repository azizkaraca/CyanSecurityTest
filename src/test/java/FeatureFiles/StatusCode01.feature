Feature: Status Code Functionality

  Scenario: Status Code Control

    Given Navigate to Status Code Page

    When User Click the Code
      | code200 |
    Then Verify User reach the Clicked Code
      | success200 |200|
    And Back to Main Page
      | back |

    When User Click the Code
      | code301 |
    Then Verify User reach the Clicked Code
      | success301 |301|
    And Back to Main Page
      | back |

    When User Click the Code
      | code404 |
    Then Verify User reach the Clicked Code
      | success404 |404|
    And Back to Main Page
      | back |

    When User Click the Code
      | code500 |
    Then Verify User reach the Clicked Code
      | success500 |500|