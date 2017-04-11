class Player

	attr_reader :name, :age, :skill_level

	def initialize(name, age, skill_level)
		@name = name
		@age = age
		@skill_level = skill_level
	end

	def to_s
		"#{@name}: Age: #{@age} and Skill: #{@skill_level}"
	end

end
