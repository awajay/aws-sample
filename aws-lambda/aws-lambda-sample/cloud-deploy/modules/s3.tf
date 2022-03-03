resource "aws_s3_bucket" "bucket_recv" {
    bucket_prefix = "${var.env}-"
    bucket = "recv"
    force_destroy = var.force_destroy_on
}

resource "aws_s3_bucket_notification" "bucket_notification" {
  bucket = "${aws_s3_bucket.bucket.id}"
  
  lambda_function {
    lambda_function_arn = "${aws_lambda_function.s3eventhandler.arn}"
    events              = ["s3:ObjectCreated:*"]
  }

  depends_on = [
    aws_lambda_permission.allow_bucket
  ]
} 