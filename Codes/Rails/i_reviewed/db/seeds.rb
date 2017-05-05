# This file should contain all the record creation needed to seed the database with its default values.
# The data can then be loaded with the rails db:seed command (or created alongside the database with db:setup).
#
# Examples:
#
#   movies = Movie.create([{ name: 'Star Wars' }, { name: 'Lord of the Rings' }])
#   Character.create(name: 'Luke', movie: movies.first)


Book.destroy_all

Reviewer.destroy_all
rec = Reviewer.create! name: "John Doe", password_digest: "asxas"

Book.create! [
	{name: "Harry Poter", author: "Jim Carry", reviewer: rec},
	{name: "Game of Thrones", author: "RR Martin", reviewer: rec},
	{name: "Alchemist", author: "Caul Poehlo", reviewer: rec},
	{name: "Peer-e-Kamil", author: "Umair Ahmed",reviewer: rec},
	{name: "Bang-e-Dara", author: "Allama Iqbal",reviewer: rec}

]

book = Book.first
book.notes.create! title: "Wow", note: "Nice Book"
book.notes.create! title: "Bad", note: "Waste of time"





















