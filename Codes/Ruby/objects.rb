class Person

	def initialize(name, age)
		@name = name
		@age = age
	end

	def get_info
		@additional_info = "Name: #{@name}, Age: #{@age}"
	end
end


person = Person.new("Joe", 12)
p person.instance_variables
puts person.get_info
p person.instance_variables


