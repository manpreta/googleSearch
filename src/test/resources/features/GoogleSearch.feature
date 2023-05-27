Feature: Google Search

  Scenario Outline: To validate google search result
    Given user opens google.com
    And navigates to Search and enters text '<searchText>'
    And clicks Google Search button
    Then verifies that first link is '<resultText>'

    Examples:
      | searchText              | resultText                                     |
      | New Parliament of India | New Parliament Building \| Parliament of India |
      | IPL 2023                | 2023 Indian Premier League                     |

