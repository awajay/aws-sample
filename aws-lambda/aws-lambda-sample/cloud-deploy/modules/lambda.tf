
resource "aws_lambda_function" "s3eventhandler" {
    runtime = "${var.lambda_runtime}"
    filename = "${var.lambda_filename}"
    source_code_hash = "${filebase64sha256(var.lambda_filename)}"
    function_name = "${local.lambda_function_name}"
    handler = "${var.lambda_functionHandler}"
    timeout = 60
    memory_size = 256
    role = "${aws_iam_role.iam_role_for_lambda.arn}"
    depends_on = [
      aws_cloudwatch_log_group.log_group
    ]
}

resource "aws_lambda_permission" "allow_bucket" {
  statement_id  = "AllowExecutionFromS3Bucket"
  action        = "lambda:InvokeFunction"
  function_name = "${aws_lambda_function.s3eventhandler.arn}"
  principal     = "s3.amazonaws.com"
  source_arn = "${aws_s3_bucket.bucket.arn}"
}
