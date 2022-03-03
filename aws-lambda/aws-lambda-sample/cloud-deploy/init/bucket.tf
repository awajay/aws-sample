provider "aws" {
  region = "ap-south-1"
  profile = "ajay"
}
resource "aws_s3_bucket" "tf_state" {
  bucket = "ajaytfstate"
  #acl    = "private"

  /* server_side_encryption_configuration {
    rule {
      apply_server_side_encryption_by_default {
        sse_algorithm = "AES256"
      }
    }
  }

  lifecycle {
    prevent_destroy = true
  } */
}

resource "aws_s3_bucket_public_access_block" "tf_state_access" {
  bucket = aws_s3_bucket.tf_state.id

  block_public_acls       = true
  ignore_public_acls      = true
  block_public_policy     = true
  restrict_public_buckets = true
}
