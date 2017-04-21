# This file should contain all the record creation needed to seed the database with its default values.
# The data can then be loaded with the rails db:seed command (or created alongside the database with db:setup).
#
# Examples:
#
#   movies = Movie.create([{ name: 'Star Wars' }, { name: 'Lord of the Rings' }])
#   Character.create(name: 'Luke', movie: movies.first)


Person.destroy_all

Person.create! [
	{first_name: "Tom", last_name: "XYasdZ", age: 10, login: "admin", pass: "123"},
	{first_name: "Jerry", last_name: "XYasdZ", age: 15, login: "admin1", pass: "123"},
	{first_name: "Rob", last_name: "XYZasd", age: 20, login: "admin2", pass: "123"},
	{first_name: "Oggie", last_name: "XasdYZ", age: 40, login: "admin3", pass: "123"},
	{first_name: "Pikkachu", last_name: "XsadYZ", age: 90, login: "admi4", pass: "123"},
	{first_name: "Scooby Doo", last_name: "XasdYZ", age: 30, login: "admin5", pass: "123"},
	{first_name: "Barbie", last_name: "Bilawal", age: 35, login: "admin6", pass: "123"}
]