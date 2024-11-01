# User Management API

## Table of Contents
- [Overview](#overview)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [API Endpoints](#api-endpoints)


## Overview
The User Management API is a RESTful service built with Spring Boot, designed to manage user data. It provides functionality for creating, retrieving, updating, and deleting user information, ensuring a simple and efficient way to handle user data in your applications.

## Features
- Create, read, update, and delete user information
- Search users by username or email
- Change user passwords and usernames
- Clear all user data
- Built-in error handling

## Technologies Used
- Java
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Postman for testing

## API Endpoints
- Create a User: POST /api/users
- Get All Users: GET /api/users
- Get User by ID: GET /api/users/{id}
- Change Username: PUT /api/users/changeUsername?id={id}&newUsername={newUsername}
- Change Password: PUT /api/users/changePassword?id={id}&newPassword={newPassword}
- Delete User by ID: DELETE /api/users/{id}
- Delete User by Username: DELETE /api/users/username/{username}
- Delete User by Email: DELETE /api/users/email/{email}
- Clear All Users: DELETE /api/users/clearAll
  
