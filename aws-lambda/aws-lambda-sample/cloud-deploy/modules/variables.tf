variable "aws_access_key" {
  default = ""
}

variable "aws_secret_key" {
  default = ""
}

variable "aws_region" {
  default = "ap-south-1"
}

variable "profile" {
  default = "ajay"
  type = string
}

variable "lambda_runtime" {
  default = "java8"
}

variable "lambda_functionHandler" {
    default = "com.ajayaw.cloud.awslambda.s3event.LambdaFunctionHandler"  
}

variable "lambda_filename" {
    default = "s3event-1.0.0.jar"
    type = string
}

variable "api_path" {
    default = "{proxy+}"
}

variable "env" {
  description = "Environment name [dev]"
  type = string  
}

variable "function_name" {
  description = "lambda function/service name"
  type = string
}

variable "force_destroy_on" {
  default = false  
}

locals {
  lambda_function_name = "${var.env}-${var.function_name}"
}