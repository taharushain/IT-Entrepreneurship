require_relative 'store'

class ReportingSystem

	def initialize
		@store = Store.new
	end

	def get_piano_desc
		@store.get_piano_description
	end

	def get_piano_price(str)
		@store.get_piano_price
	end

	def get_violen_desc
		@store.get_violen_description
	end

	def get_violen_price
		@store.get_violen_price
	end

end


rs = ReportingSystem.new
puts "#{rs.get_piano_desc}, costs: #{rs.get_piano_price}"
