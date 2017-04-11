class Person

	attr_reader :age
	attr_accessor :name

	def initialize (name, age)
		@name = name
		self.age= age
	end

	def age= (new_age)
		@age = @age || 5
		@age = new_age unless new_age > 120
	end
end


person1 = Person.new("Kim", 120)
puts person1.age
person1.age = 10
puts person1.age
person1.age = 200
puts person1.age