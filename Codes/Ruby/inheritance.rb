class Dog
	def to_s
		"Dog"
	end

	def bark
		"barks loudly"
	end
end

class SmallDog < Dog
	def bark
		"barks quietly"		
	end
end


dog = Dog.new
smallDog = SmallDog.new
puts "#{dog}1 #{dog.bark}"
puts "#{smallDog}2 #{smallDog.bark}"

