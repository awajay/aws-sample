resource "aws_cloudwatch_log_group" "log_group" {
  name = "/aws/lambda/${local.lambda_function_name}"
  retention_in_days = "1"
}

# allow lambda to log to cloudwatch
data "aws_iam_policy_document" "log_group_access_doc" {
  statement {
    actions = [
      "logs:CreateLogGroup",
      "logs:CreateLogStream",
      "logs:PutLogEvents"
    ]

    resources = [
      "arn:aws:logs:::*",
    ]
  }
}