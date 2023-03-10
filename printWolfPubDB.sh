#!/bin/bash

# database credentials
username="vdesai5"
password="200368285"
db_url="classdb2.csc.ncsu.edu"
database="vdesai5"

# declare an array of table names
declare -a tables=(
	"Publication"
	"Book"
	"Periodicity"
	"Periodical"
	"Chapter"
	"Article"
	"Contributor"
	"Edits"
	"AuthorsBook"
	"AuthorsArticle"
	"Address"
	"Distributor"
	"Orders"
	"Transaction"
	"Bills"
	"Wages"
)

# manually do chapter and article to avoid printing text
chapter_query="SELECT PublicationID, ChapterNumber, Title, CONCAT(LEFT(TEXT,32),'...') AS Text FROM Chapter;"
article_query="SELECT PublicationID, SequenceNumber, Title, CreationDate, CONCAT(LEFT(TEXT,32),'...')  AS Text FROM Article;"

## now loop through the above array
for table in "${tables[@]}"
do
	# if [ "$table" = "Chapter" ]; then
	# 	query="$chapter_query"
	# elif [ "$table" = "Article" ]; then
	# 	query="$article_query"
	# else
	# 	query="SELECT * FROM ${table};"
	# fi

	query="SELECT * FROM ${table};"

	echo 
	echo "${query}"
	mysql -u $username -p$password -h $db_url $database -e "${query}"
	echo
done