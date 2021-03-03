#!/bin/bash
while read filename; do
	aws s3 ls s3://path/to/folder/$filename --summarize | grep "Total Size"
done < $1
