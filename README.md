# CICD Pipeline for deploying Spring Boot Application on EC2 and ECS

This repository contains a Maven Java Spring Boot application that is deployed using GitHub Actions. The deployment utilizes a custom GitHub runner hosted on AWS EC2, and it includes two branches for different deployment strategies: `deploy` for EC2 and `deploy-to-ecs` for AWS ECR.

## Table of Contents

- [Features](#features)
- [Prerequisites](#prerequisites)
- [Deployment](#deployment)
  - [Deploy to EC2](#deploy-to-ec2)
  - [Deploy to ECS](#deploy-to-ecs)
- [Static Code Analysis with SonarQube](#static-code-analysis-with-sonarqube)
- [GitHub Actions Workflows](#github-actions-workflows)
- [Custom GitHub Runner](#custom-github-runner)

## Features

- CI/CD with GitHub Actions
- Deployment to AWS EC2 and AWS ECR
- Static code analysis integrated with SonarQube
- Maven build for Java Spring Boot application
- Custom GitHub runner setup for optimized builds

## Prerequisites

Before deploying the application, ensure you have the following:

- An AWS account with necessary permissions for EC2 and ECR
- GitHub repository access
- Maven installed on your local machine
- Docker installed for ECS deployment
- SonarQube server access for static code analysis

## Deployment

### Deploy to EC2

1. **Branch**: `deploy`
2. **Workflow**: The application is built using Maven and deployed to an EC2 instance using a custom GitHub Action workflow.

#### Steps:
- Push your code to the `deploy` branch.
- The GitHub Action will automatically build the application and deploy it to the specified EC2 instance.

### Deploy to ECS

1. **Branch**: `deploy-to-ecs`
2. **Workflow**: This branch builds the Docker image of the application and pushes it to AWS ECR, followed by deployment to ECS.

#### Steps:
- Push your code to the `deploy-to-ecs` branch.
- The GitHub Action will build the Docker image, push it to ECR, and deploy it to the specified ECS service.

## Static Code Analysis with SonarQube

This project integrates SonarQube for static code analysis to ensure code quality and maintainability. The SonarQube analysis is performed during the CI/CD process.

### Setup Instructions

1. **SonarQube Server**: Ensure you have access to a SonarQube server. You can use a self-hosted instance or a cloud-based service.
2. **SonarQube Scanner**: Include the SonarQube Scanner plugin in your Maven `pom.xml`:

   ```xml
   <build>
       <plugins>
           <plugin>
               <groupId>org.sonarsource.scanner.maven</groupId>
               <artifactId>sonar-maven-plugin</artifactId>
               <version>3.9.0.2155</version>
           </plugin>
       </plugins>
   </build>
   ```

3. **Configuration**: Configure your `sonar-project.properties` file with your SonarQube server details.

4. **GitHub Actions Workflow**: The GitHub Actions workflows have been updated to include steps for running SonarQube analysis.

## GitHub Actions Workflows

The repository contains the following GitHub Actions workflows:

- `.github/workflows/deploy.yml`: Workflow for deploying to EC2, including SonarQube analysis.
- `.github/workflows/deploy-to-ecs.yml`: Workflow for deploying to ECS, including SonarQube analysis.

Each workflow file contains the necessary steps to build and deploy the application while performing static code analysis.

## Custom GitHub Runner

This project utilizes a custom GitHub runner hosted on an AWS EC2 instance to execute CI/CD pipelines. Follow these steps to set up the custom runner:

1. Launch an EC2 instance with appropriate specifications.
2. Install the GitHub runner software on the instance.
3. Register the runner with your GitHub repository using the provided token.
4. Ensure that necessary tools (Java, Maven, Docker) are installed and configured on the runner.
