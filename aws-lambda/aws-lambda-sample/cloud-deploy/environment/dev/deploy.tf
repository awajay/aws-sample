locals {
    owner = "ajayawasthimca@gmail.com"
    stack = "aws-sample-lambda"
    name = "aws-sample-lambda"
}

module "s3" {
  source = "../../modules"
  env = "dev"
  function_name = "s3eventhandler"
  lambda_filename = "../../../target/s3event-1.0.0.jar"
}

terraform {
    required_version = "1.1.6"
    backend "s3" { }
}
