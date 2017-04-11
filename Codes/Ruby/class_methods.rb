class MathFunctions
	def self.double(var)
		times_called
		var * 2
	end


	class << self
		def times_called
			@@times_called ||=0
			@@times_called += 1
		end
	end
end


def MathFunctions.triple(var)
	times_called
	var * 3	
end


puts MathFunctions.double 5
puts MathFunctions.triple 3
puts MathFunctions.times_called