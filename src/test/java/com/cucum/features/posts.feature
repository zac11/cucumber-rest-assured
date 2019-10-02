@postsapi
Feature: Get all posts information
	Scenario: Get information about Posts
		Given JSON post API is hit
		Then response should be 200