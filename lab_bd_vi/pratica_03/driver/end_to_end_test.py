import unittest 
from selenium.webdriver import Firefox
from time import sleep

class EndToEndTest(unittest.TestCase):
  def setUp(self):
    self.driver = Firefox()
    self.url = "http://localhost:5000"

  def test_partition_custom_log(self):
    browser = self.driver
    browser.get(self.url)

    base_input = browser.find_element_by_id("base-input")
    log_number_input = browser.find_element_by_id("log-number-input")
    result_label = browser.find_element_by_id("result-label")
    submit_button = browser.find_element_by_id("submit-button")

    expected = "2"
    message = "Test fail to test this requisition"

    sleep(1.5)

    base_input.clear()
    log_number_input.clear()

    base_input.send_keys("2")
    log_number_input.send_keys("4")

    submit_button.click()

    self.assertEqual(result_label.text, expected, message)

    sleep(1.5)

  def test_partition_one(self):
    browser = self.driver
    browser.get(self.url)

    base_input = browser.find_element_by_id("base-input")
    log_number_input = browser.find_element_by_id("log-number-input")
    result_label = browser.find_element_by_id("result-label")
    submit_button = browser.find_element_by_id("submit-button")

    expected = "-0.7"
    message = "Test fail to test this requisition"    

    sleep(1.5)

    base_input.clear()
    base_input.send_keys("10")

    log_number_input.clear()
    log_number_input.send_keys("0.2")

    submit_button.click()

    sleep(1.5)

    self.assertEqual(result_label.text, expected, message)

  def test_partition_two(self):
    browser = self.driver
    browser.get(self.url)

    base_input = browser.find_element_by_id("base-input")
    log_number_input = browser.find_element_by_id("log-number-input")
    result_label = browser.find_element_by_id("result-label")
    submit_button = browser.find_element_by_id("submit-button")

    expected = "0.51"
    message = "Test fail to test this requisition"

    base_input.clear()
    base_input.send_keys("10")

    log_number_input.clear()
    log_number_input.send_keys("3.2")

    submit_button.click()

    sleep(1.5)

    self.assertEqual(result_label.text, expected, message)

  def test_partition_three(self):
    browser = self.driver
    browser.get(self.url)

    base_input = browser.find_element_by_id("base-input")
    log_number_input = browser.find_element_by_id("log-number-input")
    result_label = browser.find_element_by_id("result-label")
    submit_button = browser.find_element_by_id("submit-button")

    expected = "1.23"
    message = "Test fail to test this requisition"

    base_input.clear()
    base_input.send_keys("10")

    log_number_input.clear()
    log_number_input.send_keys("17")

    submit_button.click()

    sleep(1.5)

    self.assertEqual(result_label.text, expected, message)

  def tearDown(self):
      self.driver.close()

if __name__ == "__main__":
    unittest.main()